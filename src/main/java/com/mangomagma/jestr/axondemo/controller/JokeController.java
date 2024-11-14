package com.mangomagma.jestr.axondemo.controller;

import com.mangomagma.jestr.axondemo.entity.Joke;
import com.mangomagma.jestr.axondemo.event.JokeAssignmentRequested;
import com.mangomagma.jestr.axondemo.event.JokeCreationRequested;
import com.mangomagma.jestr.axondemo.event.JokeDeletionRequested;
import com.mangomagma.jestr.axondemo.resource.*;
import com.mangomagma.jestr.axondemo.service.JokeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.axonframework.eventhandling.gateway.EventGateway;

import java.util.UUID;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    private final EventGateway eventGateway;
    private final JokeService jokeService;

    public JokeController(final EventGateway eventGateway, final JokeService jokeService) {
      this.eventGateway = eventGateway;
      this.jokeService = jokeService;
    }

    @PostMapping
    public ResponseEntity<CreateJokeResponse> createJoke(final @RequestBody @Valid CreateJokeRequest createJokeRequest) {
        final var jokeId = UUID.randomUUID();
        final var event = new JokeCreationRequested(jokeId, createJokeRequest);
        eventGateway.publish(event);
        return ResponseEntity.ok(new CreateJokeResponse(jokeId));
    }

    @GetMapping("/{jokeId}")
    public ResponseEntity<GetJokeResponse> getJoke(final @PathVariable UUID jokeId) {
        final Joke joke = jokeService.getJoke(jokeId);
        return ResponseEntity.ok(new GetJokeResponse(joke));
    }

    @DeleteMapping("/{jokeId}")
    public ResponseEntity<Void> deleteJoke(final @PathVariable UUID jokeId) {
        final var event = new JokeDeletionRequested(jokeId);
        eventGateway.publish(event);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{jokeId}/assignments")
    public ResponseEntity<Void> assignJoke(final @PathVariable UUID jokeId,
                                           final @RequestBody @Valid AssignJokeRequest assignJokeRequest) {
        var event = new JokeAssignmentRequested(jokeId, assignJokeRequest);
        eventGateway.publish(event);
        return ResponseEntity.noContent().build();
    }

}
