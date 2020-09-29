package com.telRan.tests.model;

public class Board {
    private  String boardName;
    private  String boardVisibility;

    public Board withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board withTeamVisibility(String teamVisibility) {
        this.boardVisibility = teamVisibility;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getBoardVisibility() {
        return boardVisibility;
    }
}
