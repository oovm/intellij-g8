package com.github.projectfluent.ide.highlight

import g8.intellij.G8Bundle
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts.AttributeDescriptor
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

enum class FluentHighlightColor(humanName: Supplier<@AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    IDIOM_SYMBOL(G8Bundle.messagePointer("color.token.symbol.idiom"), Default.METADATA),
    IDIOM_MARK(G8Bundle.messagePointer("color.token.idiom_mark"), IDIOM_SYMBOL.textAttributesKey),
    PROP_MARK(G8Bundle.messagePointer("color.token.properties_mark"), KEYWORD.textAttributesKey),

    // 字面量
    NULL(G8Bundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(G8Bundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    DECIMAL(G8Bundle.messagePointer("color.token.decimal"), Default.NUMBER),
    INTEGER(G8Bundle.messagePointer("color.token.integer"), Default.NUMBER),
    STRING(G8Bundle.messagePointer("color.token.string"), Default.STRING),
    TEXT(G8Bundle.messagePointer("color.token.text"), STRING.textAttributesKey),
    STRING_ESCAPED(G8Bundle.messagePointer("color.token.text"), Default.VALID_STRING_ESCAPE),
    STRING_BAD(G8Bundle.messagePointer("color.token.text"), Default.INVALID_STRING_ESCAPE),
    // 标识符
    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    SYM_MESSAGE(G8Bundle.messagePointer("color.token.symbol.message"), Default.STATIC_FIELD),
    SYM_TERM(G8Bundle.messagePointer("color.token.symbol.term"), Default.CONSTANT),
    SYM_ATTRIBUTE(G8Bundle.messagePointer("color.token.symbol.attribute"), Default.STATIC_METHOD),
    SYM_VARIABLE(G8Bundle.messagePointer("color.token.symbol.variable"), Default.REASSIGNED_PARAMETER),
    SYM_FUNCTION(G8Bundle.messagePointer("color.token.symbol.function"), Default.PREDEFINED_SYMBOL),
    //
    TYPE_HINT(G8Bundle.messagePointer("color.token.symbol.type"), Default.CLASS_NAME),

    // 标点符号
    PARENTHESES(OptionsBundle.messagePointer("options.language.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(OptionsBundle.messagePointer("options.language.defaults.brackets"), Default.BRACKETS),
    BRACES(OptionsBundle.messagePointer("options.language.defaults.braces"), Default.BRACES),
    DOT(OptionsBundle.messagePointer("options.language.defaults.dot"), Default.DOT),
    STAR(G8Bundle.messagePointer("color.token.default"), Default.KEYWORD),
    COMMA(OptionsBundle.messagePointer("options.language.defaults.comma"), Default.COMMA),
    SET(G8Bundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
    SEMICOLON(OptionsBundle.messagePointer("options.language.defaults.semicolon"), Default.SEMICOLON),

    // 注释
    LINE_COMMENT(OptionsBundle.messagePointer("options.language.defaults.line.comment"), Default.LINE_COMMENT),
    BLOCK_COMMENT(OptionsBundle.messagePointer("options.language.defaults.block.comment"), Default.BLOCK_COMMENT),
    DOC_COMMENT(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.DOC_COMMENT),

    // 错误
    BAD_CHARACTER(
        OptionsBundle.messagePointer("options.java.attribute.descriptor.bad.character"),
        HighlighterColors.BAD_CHARACTER
    ),

    // 废弃
    EXTENSION(OptionsBundle.messagePointer("options.language.defaults.metadata"), Default.METADATA),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("fluent.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}
