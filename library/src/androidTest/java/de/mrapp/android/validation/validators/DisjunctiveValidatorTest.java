/*
 * Copyright 2015 - 2018 Michael Rapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package de.mrapp.android.validation.validators;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import de.mrapp.android.validation.Validator;

/**
 * Tests the functionality of the class {@link DisjunctiveValidator}.
 *
 * @author Michael Rapp
 */
public class DisjunctiveValidatorTest extends AndroidTestCase {

    /**
     * An implementation of the abstract class {@link AbstractValidator}, which is needed for test
     * purposes.
     */
    private class AbstractValidatorImplementation extends AbstractValidator<Object> {

        /**
         * The result, which is returned by the validator.
         */
        private final boolean result;

        /**
         * Creates a new validator, which should be able to validate values.
         *
         * @param errorMessage
         *         The error message, which should be shown, if the validation fails, as an instance
         *         of the type {@link CharSequence}. The error message may not be null
         * @param result
         *         The result, which should be returned by the validator
         */
        public AbstractValidatorImplementation(final CharSequence errorMessage,
                                               final boolean result) {
            super(errorMessage);
            this.result = result;
        }

        @Override
        public boolean validate(final Object value) {
            return result;
        }

    }

    /**
     * Tests, if all properties are correctly initialized by the constructor, which expects a char
     * sequence as a parameter.
     */
    @SuppressWarnings("unchecked")
    public final void testConstructorWithCharSequenceParameter() {
        CharSequence errorMessage = "errorMessage";
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", true);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", true);
        Validator<Object>[] validators = new Validator[2];
        validators[0] = validator1;
        validators[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                new DisjunctiveValidator<>(errorMessage, validators);
        assertEquals(errorMessage, disjunctiveValidator.getErrorMessage());
        assertEquals(validators, disjunctiveValidator.getValidators());
    }

    /**
     * Ensures, that a {@link NullPointerException} is thrown by the constructor, which expects a
     * char sequence as a parameter, if the validators are null.
     */
    public final void testConstructorWithCharSequenceParameterThrowsNullPointerException() {
        try {
            Validator<Object>[] validators = null;
            new DisjunctiveValidator<>("foo", validators);
            Assert.fail();
        } catch (NullPointerException e) {

        }
    }

    /**
     * Ensures, that an {@link IllegalArgumentException} is thrown by the constructor, which expects
     * a char sequence as a parameter, if the validators are empty.
     */
    @SuppressWarnings("unchecked")
    public final void testConstructorWithCharSequenceParameterThrowsIllegalArgumentException() {
        try {
            Validator<Object>[] validators = new Validator[0];
            new DisjunctiveValidator<>("foo", validators);
            Assert.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Tests, if all properties are correctly initialized by the constructor, which expects a
     * context and a resource ID as parameters.
     */
    @SuppressWarnings("unchecked")
    public final void testConstructorWithContextAndResourceIdParameters() {
        CharSequence errorMessage = getContext().getText(android.R.string.cancel);
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", true);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", true);
        Validator<Object>[] validators = new Validator[2];
        validators[0] = validator1;
        validators[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                new DisjunctiveValidator<>(getContext(), android.R.string.cancel, validators);
        assertEquals(errorMessage, disjunctiveValidator.getErrorMessage());
        assertEquals(validators, disjunctiveValidator.getValidators());
    }

    /**
     * Ensures, that a {@link NullPointerException} is thrown by the constructor, which expects a
     * context and a resource ID as parameters, if the validators are null.
     */
    public final void testConstructorWithContextAndResourceIdParametersThrowsNullPointerException() {
        try {
            Validator<Object>[] validators = null;
            new DisjunctiveValidator<>(getContext(), android.R.string.cancel, validators);
            Assert.fail();
        } catch (NullPointerException e) {

        }
    }

    /**
     * Ensures, that an {@link IllegalArgumentException} is thrown by the constructor, which expects
     * a context and a resource ID as parameters, if the validators are empty.
     */
    public final void testConstructorWithContextAndResourceIdParametersThrowsIllegalArgumentException() {
        try {
            @SuppressWarnings("unchecked") Validator<Object>[] validators = new Validator[0];
            new DisjunctiveValidator<>(getContext(), android.R.string.cancel, validators);
            Assert.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Tests, if all properties are correctly initialized by the factory method, which expects a
     * char sequence as a parameter.
     */
    @SuppressWarnings("unchecked")
    public final void testFactoryMethodWithCharSequenceParameter() {
        CharSequence errorMessage = "errorMessage";
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", true);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", true);
        Validator<Object>[] validators = new Validator[2];
        validators[0] = validator1;
        validators[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                DisjunctiveValidator.create(errorMessage, validators);
        assertEquals(errorMessage, disjunctiveValidator.getErrorMessage());
        assertEquals(validators, disjunctiveValidator.getValidators());
    }

    /**
     * Ensures, that a {@link NullPointerException} is thrown by the factory method, which expects a
     * char sequence as a parameter, if the validators are null.
     */
    public final void testFactoryMethodWithCharSequenceParameterThrowsNullPointerException() {
        try {
            Validator<Object>[] validators = null;
            DisjunctiveValidator.create("foo", validators);
            Assert.fail();
        } catch (NullPointerException e) {

        }
    }

    /**
     * Ensures, that an {@link IllegalArgumentException} is thrown by the factory method, which
     * expects a char sequence as a parameter, if the validators are empty.
     */
    @SuppressWarnings("unchecked")
    public final void testFactoryMethodWithCharSequenceParameterThrowsIllegalArgumentException() {
        try {
            Validator<Object>[] validators = new Validator[0];
            DisjunctiveValidator.create("foo", validators);
            Assert.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Tests, if all properties are correctly initialized by the factory method, which expects a
     * context and a resource ID as parameters.
     */
    @SuppressWarnings("unchecked")
    public final void testFactoryMethodWithContextAndResourceIdParameters() {
        CharSequence errorMessage = getContext().getText(android.R.string.cancel);
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", true);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", true);
        Validator<Object>[] validators = new Validator[2];
        validators[0] = validator1;
        validators[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                DisjunctiveValidator.create(getContext(), android.R.string.cancel, validators);
        assertEquals(errorMessage, disjunctiveValidator.getErrorMessage());
        assertEquals(validators, disjunctiveValidator.getValidators());
    }

    /**
     * Ensures, that a {@link NullPointerException} is throw by the factory method, which expects a
     * context and a resource ID as parameters, if the validators are null.
     */
    public final void testFactoryMethodWithContextAndResourceIdParametersThrowsNullPointerException() {
        try {
            Validator<Object>[] validators = null;
            DisjunctiveValidator.create(getContext(), android.R.string.cancel, validators);
            Assert.fail();
        } catch (NullPointerException e) {

        }
    }

    /**
     * Ensures, that an {@link IllegalArgumentException} is throw by the factory method, which
     * expects a context and a resource ID as parameters, if the validators are empty.
     */
    @SuppressWarnings("unchecked")
    public final void testFactoryMethodWithContextAndResourceIdParametersThrowsIllegalArgumentException() {
        try {
            Validator<Object>[] validators = new Validator[0];
            DisjunctiveValidator.create(getContext(), android.R.string.cancel, validators);
            Assert.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Tests the functionality of the method, which allows to set the validators.
     */
    @SuppressWarnings("unchecked")
    public final void testSetValidators() {
        CharSequence errorMessage = "errorMessage";
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", true);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", true);
        Validator<Object>[] validators1 = new Validator[1];
        validators1[0] = validator1;
        Validator<Object>[] validators2 = new Validator[2];
        validators2[0] = validator1;
        validators2[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                new DisjunctiveValidator<>(errorMessage, validators1);
        disjunctiveValidator.setValidators(validators2);
        assertEquals(validators2, disjunctiveValidator.getValidators());
    }

    /**
     * Ensures, that a {@link NullPointerException} is thrown by the method, which allows to set the
     * validators, if the validators are null.
     */
    @SuppressWarnings("unchecked")
    public final void testSetValidatorsThrowsNullPointerException() {
        try {
            CharSequence errorMessage = "errorMessage";
            Validator<Object> validator = new AbstractValidatorImplementation("foo", true);
            Validator<Object>[] validators1 = new Validator[1];
            validators1[0] = validator;
            DisjunctiveValidator<Object> disjunctiveValidator =
                    new DisjunctiveValidator<>(errorMessage, validators1);
            Validator<Object>[] validators2 = null;
            disjunctiveValidator.setValidators(validators2);
            Assert.fail();
        } catch (NullPointerException e) {

        }
    }

    /**
     * Tests the functionality of the validate-method, if all validators succeed.
     */
    @SuppressWarnings("unchecked")
    public final void testValidateWhenAllValidatorsSucceed() {
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", true);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", true);
        Validator<Object>[] validators = new Validator[2];
        validators[0] = validator1;
        validators[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                new DisjunctiveValidator<>("foo", validators);
        assertTrue(disjunctiveValidator.validate(new Object()));
    }

    /**
     * Tests the functionality of the validate-method, if not all validators succeed.
     */
    @SuppressWarnings("unchecked")
    public final void testValidateWhenNotAllValidatorsSucceed() {
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", true);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", false);
        Validator<Object>[] validators = new Validator[2];
        validators[0] = validator1;
        validators[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                new DisjunctiveValidator<>("foo", validators);
        assertTrue(disjunctiveValidator.validate(new Object()));
    }

    /**
     * Tests the functionality of the validate-method, if no validators succeed.
     */
    @SuppressWarnings("unchecked")
    public final void testValidateWhenNoValidatorsSucceed() {
        Validator<Object> validator1 = new AbstractValidatorImplementation("foo", false);
        Validator<Object> validator2 = new AbstractValidatorImplementation("bar", false);
        Validator<Object>[] validators = new Validator[2];
        validators[0] = validator1;
        validators[1] = validator2;
        DisjunctiveValidator<Object> disjunctiveValidator =
                new DisjunctiveValidator<>("foo", validators);
        assertFalse(disjunctiveValidator.validate(new Object()));
    }

}