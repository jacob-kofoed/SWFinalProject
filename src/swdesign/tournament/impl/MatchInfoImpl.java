
package swdesign.tournament.impl;

import swdesign.game.Game;
import swdesign.game.GameInstance;
import swdesign.tournament.MatchInfo;
import swdesign.tournament.ParticipantInfo;

public class MatchInfoImpl implements MatchInfo, Runnable {
    
    Game game;
    private GameInstance.Result result;
    private boolean hasFinished;
    private ParticipantInfo participantA;
    private ParticipantInfo participantB;
    
    public MatchInfoImpl(int id, Game game) {
        this.game = game;
        hasFinished = false;
    }
    
    @Override
    public int matchID() {
        return id;
    }
    
    @Override
    public ParticipantInfo getParticipantA() {
        return participantA;
    }

    @Override
    public ParticipantInfo getParticipantB() {
        return participantB;
    }

    @Override
    public boolean hasFinished() {
        return hasFinished;
    }

    @Override
    public GameInstance.Result getResult() {
        return result;
    }

    @Override
    public void run() {
        result = game.newInstance().playGame(getParticipantA(), getParticipantB());
        hasFinished = true;
    }
    
}