package com.epicness.cuboids.game.logic.other;

import static com.badlogic.gdx.Input.Keys.C;
import static com.badlogic.gdx.Input.Keys.I;
import static com.badlogic.gdx.Input.Keys.V;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.fundamentals.constants.ColorConstants.WHITE_50;

import com.epicness.cuboids.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.Text;

public class InstructionsHandler extends GameLogicHandler {

    private Text instructionsText, cakeText;

    @Override
    protected void init() {
        instructionsText = stuff.getInstructionsText();
        showInstructions();
        cakeText = stuff.getWorld2D().getCakeText();
    }

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case I:
                toggleInstructions();
                break;
            case C:
            case V:
                cakeText.setColor(cakeText.getColor().equals(WHITE) ? WHITE_50 : WHITE);
                cakeText.setText(cakeText.getText().equals("C") ? "CAKE" : "C");
                break;
        }
    }

    private void toggleInstructions() {
        if (instructionsText.getColor().equals(CLEAR)) {
            showInstructions();
        } else {
            hideInstructions();
        }
    }

    private void showInstructions() {
        instructionsText.setColor(WHITE);
    }

    public void hideInstructions() {
        instructionsText.setColor(CLEAR);
    }
}