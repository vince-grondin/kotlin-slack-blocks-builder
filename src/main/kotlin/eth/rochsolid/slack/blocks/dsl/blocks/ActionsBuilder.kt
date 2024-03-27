package eth.rochsolid.slack.blocks.dsl.blocks

import eth.rochsolid.slack.blocks.dsl.BlockDslMarker
import eth.rochsolid.slack.blocks.models.blocks.Actions
import eth.rochsolid.slack.blocks.models.blocks.Block

/**
 * [Actions] builder.
 */
@BlockDslMarker
class ActionsBuilder : BlockBuilder() {
    private val elements = ElementsBuilder()

    fun build() = Actions(
        blockID = blockID?.let(Block::BlockID),
        elements = elements.build()
    )

    fun elements(fn: ElementsBuilder.() -> Unit) = apply {
        elements.apply(fn)
    }
}
