package com.github.projectfluent.language.file

import g8.intellij.G8Bundle
import g8.intellij.G8Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class FluentFileType private constructor() : LanguageFileType(G8Language) {
    override fun getName(): String = G8Language.id

    override fun getDescription(): String = G8Bundle.message("filetype.description")

    override fun getDefaultExtension(): String = "ftl;"

    override fun getIcon(): Icon = FluentIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = FluentFileType()
    }
}