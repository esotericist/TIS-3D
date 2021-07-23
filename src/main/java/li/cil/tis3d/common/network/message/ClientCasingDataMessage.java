package li.cil.tis3d.common.network.message;

import io.netty.buffer.ByteBuf;
import li.cil.tis3d.api.machine.Casing;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

public final class ClientCasingDataMessage extends AbstractCasingDataMessage {
    public ClientCasingDataMessage(final Casing casing, final ByteBuf data) {
        super(casing, data);
    }

    public ClientCasingDataMessage(final FriendlyByteBuf buffer) {
        super(buffer);
    }

    // --------------------------------------------------------------------- //
    // AbstractMessage

    @Override
    protected void handleMessage(final NetworkEvent.Context context) {
        final Level world = getServerWorld(context);
        if (world != null) {
            handleMessage(world);
        }
    }
}
