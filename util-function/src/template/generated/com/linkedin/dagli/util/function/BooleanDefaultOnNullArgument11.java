// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/DefaultOnNullArgument.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.named.Named;
import java.util.Objects;


/**
 * A function class implementing BooleanFunction11.Serializable<A, B, C, D, E, F, G, H, I, J, K> that returns false if any of
 * the function's inputs are null.
 */
class BooleanDefaultOnNullArgument11<A, B, C, D, E, F, G, H, I, J, K> implements
    BooleanFunction11.Serializable<A, B, C, D, E, F, G, H, I, J, K>, Named {
  private static final long serialVersionUID = 1;
  private static final int CLASS_HASH = BooleanDefaultOnNullArgument11.class.hashCode();
  private final BooleanFunction11<A, B, C, D, E, F, G, H, I, J, K> _wrapped;

  BooleanDefaultOnNullArgument11(BooleanFunction11<A, B, C, D, E, F, G, H, I, J, K> wrapped) {
    // stacking this wrapper multiple times should be idempotent:
    if (wrapped instanceof BooleanDefaultOnNullArgument11) {
      _wrapped = ((BooleanDefaultOnNullArgument11) wrapped)._wrapped;
    } else {
      _wrapped = Objects.requireNonNull(wrapped);
    }
  }

  @Override
  public BooleanDefaultOnNullArgument11<A, B, C, D, E, F, G, H, I, J, K> safelySerializable() {
    return new BooleanDefaultOnNullArgument11<>(
        ((BooleanFunction11.Serializable<A, B, C, D, E, F, G, H, I, J, K>) _wrapped).safelySerializable());
  }

  @Override
  public boolean apply(A value1, B value2, C value3, D value4, E value5, F value6, G value7, H value8, I value9,
      J value10, K value11) {
    if (value1 == null || value2 == null || value3 == null || value4 == null || value5 == null || value6 == null
        || value7 == null || value8 == null || value9 == null || value10 == null || value11 == null) {
      return false;
    }
    return _wrapped.apply(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11);
  }

  @Override
  public int hashCode() {
    return CLASS_HASH + _wrapped.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof BooleanDefaultOnNullArgument11) {
      return this._wrapped.equals(((BooleanDefaultOnNullArgument11) obj)._wrapped);
    }
    return false;
  }

  @Override
  public String toString() {
    return "arg == null ? false : " + Named.getName(_wrapped);
  }

  @Override
  public String getShortName() {
    return "arg == null ? false : " + Named.getShortName(_wrapped);
  }
}
