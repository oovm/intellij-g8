package com.github.projectfluent.language.psi

import g8.intellij.G8Language
import com.intellij.psi.tree.IElementType

class FluentTokenType(debugName: String) : IElementType(debugName, G8Language) {
    override fun toString(): String = "FluentToken.${super.toString()}"
}

