package eth.rochsolid.slack.blocks.dsl.blocks

import eth.rochsolid.slack.blocks.dsl.BlockDslMarker

@BlockDslMarker
sealed class BlockBuilder(var blockID: String? = null)
