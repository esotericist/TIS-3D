package li.cil.tis3d.client.manual.provider;

import li.cil.manual.api.ManualModel;
import li.cil.manual.api.prefab.provider.NamespacePathProvider;
import li.cil.tis3d.api.API;
import li.cil.tis3d.client.manual.Manuals;
import li.cil.tis3d.common.tileentity.CasingTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Optional;

public class ModPathProvider extends NamespacePathProvider {
    public ModPathProvider() {
        super(API.MOD_ID);
    }

    @Override
    public boolean matches(final ManualModel manual) {
        return Objects.equals(manual, Manuals.MANUAL.get());
    }

    @Override
    public Optional<String> pathFor(final World world, final BlockPos pos, final Direction face) {
        final TileEntity tileEntity = world.getBlockEntity(pos);
        if (tileEntity instanceof CasingTileEntity) {
            final CasingTileEntity casing = (CasingTileEntity) tileEntity;
            final ItemStack moduleStack = casing.getItem(face.ordinal());
            final Optional<String> path = pathFor(moduleStack);
            if (path.isPresent()) {
                return path;
            }
        }

        return super.pathFor(world, pos, face);
    }
}
