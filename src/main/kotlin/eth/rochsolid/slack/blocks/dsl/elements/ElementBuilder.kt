package eth.rochsolid.slack.blocks.dsl.elements

import eth.rochsolid.slack.blocks.dsl.BlockDslMarker
import eth.rochsolid.slack.blocks.models.elements.Element

@BlockDslMarker
sealed class ElementBuilder<T : Element> {
    var actionID: String? = null

    abstract fun build(): T
}
