package location.battle;

import location.BattleLocation;
import player.Player;

public class Forest extends BattleLocation {

    public Forest(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return false;
    }

}
