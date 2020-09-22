package com.telRan.tests.model;

public class Board {
    private  String boardName;
    private  String teamVisibility;

    public Board withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board withTeamVisibility(String teamVisibility) {
        this.teamVisibility = teamVisibility;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getTeamVisibility() {
        return teamVisibility;
    }
}
