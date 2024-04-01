package eth.rochsolid.slack.blocks.models.compositionobjects

import kotlinx.serialization.SerialName

/**
 * Defines a filter for the list of options in a conversation selector menu.
 *
 * The menu can be either a conversations select menu or a [MultiConversationSelect] conversations multi-select menu.
 *
 * Example ([view this example in BlockKit Builder](https://api.slack.com/tools/block-kit-builder?mode=modal&view=%7B%22type%22%3A%22modal%22%2C%22title%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22My%20App%22%2C%22emoji%22%3Atrue%7D%2C%22submit%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Submit%22%2C%22emoji%22%3Atrue%7D%2C%22close%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Cancel%22%2C%22emoji%22%3Atrue%7D%2C%22blocks%22%3A%5B%7B%22type%22%3A%22input%22%2C%22element%22%3A%7B%22type%22%3A%22conversations_select%22%2C%22placeholder%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Select%20a%20conversation%22%2C%22emoji%22%3Atrue%7D%2C%22filter%22%3A%7B%22include%22%3A%5B%22public%22%2C%22mpim%22%5D%2C%22exclude_bot_users%22%3Atrue%7D%7D%2C%22label%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Choose%20the%20conversation%20to%20publish%20your%20result%20to%3A%22%2C%22emoji%22%3Atrue%7D%7D%5D%7D)):
 * ```json
 * {
 *     "type": "conversations_select",
 *     "placeholder": {
 *         "type": "plain_text",
 *         "text": "Select a conversation",
 *         "emoji": true
 *     },
 *     "filter": {
 *         "include": [
 *             "public",
 *             "mpim"
 *         ],
 *         "exclude_bot_users": true
 *     }
 * }
 * ```
 */
data class ConversationFilter(
    /**
     * Indicates which type of conversations should be _included_ in the list.
     * When this field is provided, any conversations that do not match will be excluded
     * The array cannot be empty.
     */
    val include: List<ConversationType>,
    /**
     * Indicates whether to exclude external [shared channels](https://api.slack.com/enterprise/shared-channels) from
     * conversation lists. This field will not exclude users from shared channels.
     * Defaults to `false`.
     */
    @SerialName("exclude_external_shared_channels")
    val excludeExternalSharedChannels: Boolean? = false,
    /**
     * Indicates whether to exclude bot users from conversation lists.
     * Defaults to `false`.
     */
    @SerialName("exclude_bot_users")
    val excludeBotUsers: Boolean? = false
) {
    enum class ConversationType {
        @SerialName("im")
        IM,

        @SerialName("mpim")
        MPIM,

        @SerialName("private")
        PRIVATE,

        @SerialName("public")
        PUBLIC
    }
}
