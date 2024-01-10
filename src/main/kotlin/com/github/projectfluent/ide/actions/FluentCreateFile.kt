package com.github.projectfluent.ide.actions

import com.github.projectfluent.language.file.FluentIcons.Companion.FILE
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.Builder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import g8.intellij.G8Bundle

class FluentCreateFile :
    CreateFileFromTemplateAction(name, description, FILE) {
    companion object {
        private val name = G8Bundle.message("action.create_file")
        private val description = G8Bundle.message("action.create_file.description")
        // See [resources/colors/fileTemplate]
        private const val templatePath = "Fluent File";
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder.setTitle(name).addKind("Empty file", FILE, templatePath)
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
