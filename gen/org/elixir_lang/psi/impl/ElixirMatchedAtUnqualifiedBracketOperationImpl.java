// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi.impl;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.elixir_lang.psi.ElixirAtPrefixOperator;
import org.elixir_lang.psi.ElixirBracketArguments;
import org.elixir_lang.psi.ElixirMatchedAtUnqualifiedBracketOperation;
import org.elixir_lang.psi.ElixirVisitor;
import org.jetbrains.annotations.NotNull;

public class ElixirMatchedAtUnqualifiedBracketOperationImpl extends ElixirMatchedExpressionImpl implements ElixirMatchedAtUnqualifiedBracketOperation {

  public ElixirMatchedAtUnqualifiedBracketOperationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ElixirVisitor) ((ElixirVisitor)visitor).visitMatchedAtUnqualifiedBracketOperation(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ElixirAtPrefixOperator getAtPrefixOperator() {
    return findNotNullChildByClass(ElixirAtPrefixOperator.class);
  }

  @Override
  @NotNull
  public ElixirBracketArguments getBracketArguments() {
    return findNotNullChildByClass(ElixirBracketArguments.class);
  }

  @NotNull
  public OtpErlangObject quote() {
    return ElixirPsiImplUtil.quote(this);
  }

}
