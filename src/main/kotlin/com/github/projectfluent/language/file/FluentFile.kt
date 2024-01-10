package com.github.projectfluent.language.file

import g8.intellij.G8Bundle
import g8.intellij.G8Language
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class FluentFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, G8Language) {
    override fun getFileType(): FileType = FluentFileType.INSTANCE

    override fun toString(): String = G8Bundle.message("action.create_file")
}