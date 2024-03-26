package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.shared.FileExtension
import kotlinx.serialization.SerialName

private const val DEFAULT_NUMBER_OF_UPLOADABLE_FILES = 10

/**
 * Allows user to upload files.
 * In order to use the [FileInput] element within your app, your app must have the
 * [files:read](https://api.slack.com/scopes/files:read) scope.
 * There is a 10MB file size limit.
 *
 * Examples:
 * - An [Input] input block containing a [FileInput] `file_input` input element.
 * ```json
 * {
 *   "type": "input",
 *   "block_id": "input_block_id",
 *   "label": {
 *     "type": "plain_text",
 *     "text": "Upload Files"
 *   },
 *   "element": {
 *     "type": "file_input",
 *     "action_id": "file_input_action_id_1",
 *     "filetypes": ["jpg", "png"],
 *     "max_files": 5,
 *   },
 * }
 * ```
 */
data class FileInput(
    /**
     * An identifier for the input value when the parent modal is submitted.
     * You can use this when you receive a view_submission payload to
     * [identify the value of the input element](https://api.slack.com/surfaces/modals#interactions).
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    override val actionID: ActionID?,
    /**
     * A set of valid [FileExtension] [file extensions](https://api.slack.com/types/file#types) that will be accepted
     * for this element.
     * All file extensions will be accepted if filetypes is not specified.
     * This validation is provided for convenience only, and you should perform your own file type validation based on
     * what you expect to receive.
     */
    @SerialName("filetypes")
    val fileTypes: Set<FileExtension>?,
    /**
     * Maximum number of files that can be uploaded for this [FileInput] element.
     * Minimum of 1, maximum of 10.
     * Defaults to 10 if not specified.
     */
    val maxFiles: Int? = DEFAULT_NUMBER_OF_UPLOADABLE_FILES
) : Element(type = Type.FILE_INPUT)
