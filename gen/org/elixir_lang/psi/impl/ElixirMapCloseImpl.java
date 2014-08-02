// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.elixir_lang.psi.ElixirTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.elixir_lang.psi.*;

public class ElixirMapCloseImpl extends ASTWrapperPsiElement implements ElixirMapClose {

  public ElixirMapCloseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ElixirVisitor) ((ElixirVisitor)visitor).visitMapClose(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ElixirAssoc getAssoc() {
    return findChildByClass(ElixirAssoc.class);
  }

  @Override
  @Nullable
  public ElixirAssocBase getAssocBase() {
    return findChildByClass(ElixirAssocBase.class);
  }

  @Override
  @NotNull
  public ElixirCloseCurly getCloseCurly() {
    return findNotNullChildByClass(ElixirCloseCurly.class);
  }

  @Override
  @Nullable
  public ElixirKeyword getKeyword() {
    return findChildByClass(ElixirKeyword.class);
  }

}