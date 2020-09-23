// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/internal/PreparedTransformerXInternalAPI.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer.internal;

import com.linkedin.dagli.dag.DAG;
import com.linkedin.dagli.placeholder.Placeholder;
import com.linkedin.dagli.producer.Producer;

import com.linkedin.dagli.transformer.PreparedTransformer3;

import com.linkedin.dagli.transformer.PreparedTransformer1;
import com.linkedin.dagli.tuple.Tuple2;
import com.linkedin.dagli.transformer.Value0FromTuple;
import com.linkedin.dagli.transformer.Value1FromTuple;

import java.util.List;
import com.linkedin.dagli.transformer.PreparedTransformer2;


public interface PreparedTransformer2InternalAPI<A, B, R, S extends PreparedTransformer2<A, B, R>> extends
    Transformer2InternalAPI<A, B, R, S>, PreparedTransformerInternalAPI<R, S> {

  R apply(Object executionCache, A value1, B value2);

  @Override
  @SuppressWarnings("unchecked")
  default R applyUnsafe(Object executionCache, Object[] values) {
    assert values.length >= 2;
    return apply(executionCache, (A) values[0], (B) values[1]);
  }

  @Override
  @SuppressWarnings("unchecked")
  default R applyUnsafe(Object executionCache, List<?> values) {
    assert values.size() >= 2;
    return apply(executionCache, (A) values.get(0), (B) values.get(1));
  }

  @Override
  @SuppressWarnings("unchecked")
  default R applyUnsafe(Object executionCache, Object[][] values, int exampleIndex) {
    assert values.length >= 2;
    return apply(executionCache, (A) values[0][exampleIndex], (B) values[1][exampleIndex]);
  }

  @Override
  default <C> PreparedTransformer3<A, B, C, R> withArity3(Producer<? extends C> newInput3) {
    Placeholder<A> nestedPlaceholder1 = new Placeholder<>("Original Input 1");
    Placeholder<B> nestedPlaceholder2 = new Placeholder<>("Original Input 2");
    return DAG.Prepared.withPlaceholders(nestedPlaceholder1, nestedPlaceholder2, new Placeholder<C>("Ignored"))
        .withOutput(withInputs(nestedPlaceholder1, nestedPlaceholder2)).withInputs(getInput1(), getInput2(), newInput3);
  }

  @Override
  default <N> PreparedTransformer3<N, A, B, R> withPrependedArity3(Producer<? extends N> newInput1) {
    Placeholder<A> nestedPlaceholder1 = new Placeholder<>("Original Input 1");
    Placeholder<B> nestedPlaceholder2 = new Placeholder<>("Original Input 2");
    return DAG.Prepared.withPlaceholders(new Placeholder<N>("Ignored"), nestedPlaceholder1, nestedPlaceholder2)
        .withOutput(this.withInputs(nestedPlaceholder1, nestedPlaceholder2))
        .withInputs(newInput1, getInput1(), getInput2());
  }

  @Override
  default PreparedTransformer1<Tuple2<? extends A, ? extends B>, R> withArity1(
      Producer<? extends Tuple2<? extends A, ? extends B>> inputTuple) {
    Placeholder<Tuple2<? extends A, ? extends B>> placeholderTuple = new Placeholder<>("Original Inputs Tuple");

    return DAG.Prepared.withPlaceholder(placeholderTuple)
        .withOutput(withInputs(new Value0FromTuple<>(placeholderTuple), new Value1FromTuple<>(placeholderTuple)))
        .withInput(inputTuple);
  }
}