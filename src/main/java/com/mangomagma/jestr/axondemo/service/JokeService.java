package com.mangomagma.jestr.axondemo.service;

import com.mangomagma.jestr.axondemo.entity.Joke;
import com.mangomagma.jestr.axondemo.event.JokeAssignmentRequested;
import com.mangomagma.jestr.axondemo.event.JokeCreationRequested;
import com.mangomagma.jestr.axondemo.event.JokeDeletionRequested;

import java.util.UUID;

public interface JokeService {

  Joke getJoke(final UUID jokeId);

  void on(final JokeCreationRequested event);

  void on(final JokeDeletionRequested event);

  void on(final JokeAssignmentRequested event);
}
