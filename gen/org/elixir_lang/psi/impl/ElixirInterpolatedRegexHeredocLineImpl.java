// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi.impl;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.tree.IElementType;
import org.elixir_lang.psi.*;
import org.jetbrains.annotations.NotNull;

public class ElixirInterpolatedRegexHeredocLineImpl extends ASTWrapperPsiElement implements ElixirInterpolatedRegexHeredocLine {

  public ElixirInterpolatedRegexHeredocLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ElixirVisitor) ((ElixirVisitor)visitor).visitInterpolatedRegexHeredocLine(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ElixirHeredocLinePrefix getHeredocLinePrefix() {
    return findNotNullChildByClass(ElixirHeredocLinePrefix.class);
  }

  @Override
  @NotNull
  public ElixirInterpolatedRegexBody getInterpolatedRegexBody() {
    return findNotNullChildByClass(ElixirInterpolatedRegexBody.class);
  }

  public IElementType getFragmentType() {
    return ElixirPsiImplUtil.getFragmentType(this);
  }

  public InterpolatedBody getInterpolatedBody() {
    return ElixirPsiImplUtil.getInterpolatedBody(this);
  }

  @NotNull
  public OtpErlangObject quote(Heredoc heredoc, int prefixLength) {
    return ElixirPsiImplUtil.quote(this, heredoc, prefixLength);
  }

}
