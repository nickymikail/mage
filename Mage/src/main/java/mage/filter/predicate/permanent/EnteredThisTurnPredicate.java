/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mage.filter.predicate.permanent;

import mage.filter.predicate.Predicate;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author LevelX2
 */
public class EnteredThisTurnPredicate implements Predicate<Permanent> {

    @Override
    public boolean apply(Permanent input, Game game) {
        return input.getTurnsOnBattlefield() == 0;
    }

    @Override
    public String toString() {
        return "Entered this turn";
    }
}
