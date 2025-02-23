# TIS-3D Reference Manual
"The Tessellated Intelligence System is a massively parallel computer architecture comprised of non/uniformly interconnected heterogeneous nodes. The Tessellated Intelligence System is ideal for applications requiring complex data stream processing, such as automated financial trading, bulk data collection, and civilian behavioral analysis." - *TIS-100 Reference Manual*

TIS-3D is a 3-dimensional interpretation of the TIS design. Its purpose is to allow controlling other machinery and mechanisms in the world, which might otherwise require complex redstone contraptions. Or just to provide an interesting challenge on its own!

## Computer Specification
TIS-3D allows building modular and powerful computers. A computer consists of exactly one [controller](block/controller.md) and up to eight [casings](block/casing.md). Controller and [casings](block/casing.md) are connected by sharing face. The connection to the [controller](block/controller.md) is transitive: if [casing](block/casing.md) `C1` is connected to a [controller](block/controller.md), [casing](block/casing.md) `C2` is also connected to the [controller](block/controller.md) if it is connected to [casing](block/casing.md) `C1`.

A computer must have exactly one [controller](block/controller.md). If multiple [controllers](block/controller.md) are connected, directly or indirectly, the computer will not turn on. A computer must have no more than eight [casings](block/casing.md). If more than eight [casings](block/casing.md) are connected to the [controller](block/controller.md), the computer will not turn on.

To power a computer, provide the [controller](block/controller.md) with a redstone signal on any face. The speed with which the computer operates is regulated by the strength of the applied signal. Applying multiple redstone signals to a single [controller](block/controller.md) lead to undefined behavior. Contact the manufacturer of your [controller](block/controller.md) for a specification, as this may void your warranty. Providing a minimum amount of power pauses the computer. Powering off a computer completely resets its state.

## Module Specification
A [casing](block/casing.md) provides room for up to six [modules](item/index.md), each of which can be placed on one of the sides of the [casing](block/casing.md). Each [module](item/index.md) has up to four local connections to neighboring [modules](item/index.md), one for each edge of the [module](item/index.md): `up`, `right`, `down` and `left`. These ports allow [modules](item/index.md) to communicate by reading and writing individual values.

Each read/write operation is a blocking operation. The [module](item/index.md) performing the operation typically blocks until the operation has been completed. *Vendor-specific exceptions may exist*. Should two [modules](item/index.md) begin a read operation on the same shared port, they enter a deadlock. If a [module](item/index.md) writes to a port on a side with no other [module](item/index.md), it deadlocks itself. To break a deadlock, reset the computer. Hot-swapping [modules](item/index.md) is technically possible, but usually leads to undesired results.
