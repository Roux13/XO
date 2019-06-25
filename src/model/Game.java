package model;

public class Game {

    private final Player player1;

    private final Player player2;

    private final Field field;

    private final String name;

    Game(final Builder builder) {
        this.player1 = builder.getPlayer1();
        this.player2 = builder.getPlayer2();
        this.field = builder.getField();
        this.name = builder.getName();
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    // BEGIN (write your solution here)
    public static class Builder{

        private Player player1;

        private Player player2;

        private Field field;

        private String name;

        public Builder player1 (Player player1) {
            this.player1 = player1;
            return this;
        }

        public Builder player2 (Player player2) {
            this.player2 = player2;
            return this;
        }

        public Builder field (Field field) {
            this.field = field;
            return this;
        }

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Player getPlayer1() {
            return this.player1;
        }

        public Player getPlayer2() {
            return this.player2;
        }

        public Field getField() {
            return this.field;
        }

        public String getName() {
            return this.name;
        }

        public Game build() {
            return new Game(this);
        }

    }
    // END
}
