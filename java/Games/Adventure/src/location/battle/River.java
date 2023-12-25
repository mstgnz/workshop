package location.battle;

import location.BattleLocation;
import player.Player;

public class River extends BattleLocation {

    public River(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return false;
    }
}
