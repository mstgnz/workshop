package location.normal;

import location.NormalLocation;
import player.Player;

public class ToolStore extends NormalLocation {

    public ToolStore(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return false;
    }


}
