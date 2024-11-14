package com.mangomagma.jestr.axondemo.service.impl;

import com.mangomagma.jestr.axondemo.Exception.JokeNotFoundException;
import com.mangomagma.jestr.axondemo.entity.Joke;
import com.mangomagma.jestr.axondemo.event.*;
import com.mangomagma.jestr.axondemo.repository.JokeRepository;
import com.mangomagma.jestr.axondemo.service.JokeService;
import org.springframework.stereotype.Service;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.gateway.EventGateway;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class JokeServiceImpl implements JokeService {

    private final EventGateway eventGateway;
    private final JokeRepository jokeRepository;

    public JokeServiceImpl(final EventGateway eventGateway, final JokeRepository jokeRepository) {
        this.eventGateway = eventGateway;
        this.jokeRepository = jokeRepository;
    }

    @Override
    public Joke getJoke(final UUID jokeId) {
        return jokeRepository.findById(jokeId)
            .orElseThrow(JokeNotFoundException::new);

    }

    @EventHandler
    public void on(final JokeCreationRequested event) {
        final Joke joke = new Joke(event);
        jokeRepository.save(joke);
        final var jokeCreated = new JokeCreated(joke);
        eventGateway.publish(jokeCreated);
    }

    @EventHandler
    public void on(final JokeDeletionRequested event) {
        jokeRepository.deleteById(event.getJokeId());
        final var jokeDeleted = new JokeDeleted(event.getJokeId());
        eventGateway.publish(jokeDeleted);
    }

    @EventHandler
    public void on(final JokeAssignmentRequested event) {
        final int updatedCount = jokeRepository.updateJoke(event.getJokeId(),
            event.getAssignJokeRequest().getUsername(), "SUBMITTED", "ASSIGNED", LocalDateTime.now());
        if (updatedCount > 0) {
          final var jokeCreated = new JokeAssigned(event.getJokeId(), event.getAssignJokeRequest());
          eventGateway.publish(jokeCreated);
        }
    }

}

