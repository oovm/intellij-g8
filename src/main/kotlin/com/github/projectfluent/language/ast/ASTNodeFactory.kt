package com.github.projectfluent.language.ast

import g8.intellij.G8Language
import com.github.projectfluent.language.file.FluentFile
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

class ASTNodeFactory(private val project: Project) {
    fun createFile(text: String): FluentFile {
        val file =  PsiFileFactory.getInstance(project).createFileFromText("dummy.fluent", G8Language, text)
        return file as FluentFile
    }
}