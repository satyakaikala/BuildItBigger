package com.example;

import java.util.Random;

public class Joker {

    private static String[] jokes = {"What is black; white; green and bumpy? A pickle wearing a tuxedo.",
            "What do you call cheese that isn't yours? Nacho cheese!",
            "What kind of coffee was served on the Titanic? Sanka!",
            "What's the best thing to put into a pie? Your teeth!",
            "Waiter, this food tastes kind of funny? Then why aren't you laughing!",
            "Did you hear the joke about the peanut butter? I'm not telling you.",
            "Why do the French like to eat snails? Because they don't like fast food!",
            "Why did the fisherman put peanut butter into the sea? To go with the jellyfish!",
            "Why shouldn't you tell an egg a joke? Because it might crack up!"
    };

    public static String getJoke() {
        String newJoke = jokes[new Random().nextInt(jokes.length)];
        return newJoke;
    }
}
