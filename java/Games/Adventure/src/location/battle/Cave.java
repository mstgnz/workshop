package location.battle;

import location.BattleLocation;
import player.Player;

public class Cave extends BattleLocation {

    public Cave(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return false;
    }
}
