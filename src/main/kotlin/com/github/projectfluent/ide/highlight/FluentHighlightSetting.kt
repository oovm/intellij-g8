package com.github.projectfluent.ide.highlight

import g8.intellij.G8Bundle
import com.github.projectfluent.language.file.FluentIcons
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class FluentHighlightSetting : ColorSettingsPage {
    private val annotatorTags = FluentHighlightColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = FluentHighlightColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = G8Bundle.message("filetype.name")

    override fun getIcon() = FluentIcons.FILE

    override fun getHighlighter() = FluentSyntaxHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText() = javaClass.getResource("/fileTemplates/colorDemo.ftl")!!.readText()

}
