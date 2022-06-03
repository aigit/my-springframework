package org.study.mycore.beans.factory;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.lang.Nullable;
import org.study.mycore.beans.factory.support.BeanDefinitionRegistry;
import org.study.mycore.beans.factory.support.SimpleBeanDefinitionRegistry;

import java.lang.annotation.Annotation;
import java.util.function.Supplier;

public class AnnotatedBeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();

    private ConditionEvaluator conditionEvaluator;


    public AnnotatedBeanDefinitionReader(){
        this.registry = new SimpleBeanDefinitionRegistry();
    }

    /**
     * Get the BeanDefinitionRegistry that this reader operates on.
     */
    public final BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    /**
     * Set the {@code Environment} to use when evaluating whether
     * {@link Conditional @Conditional}-annotated component classes should be registered.
     * <p>The default is a {@link StandardEnvironment}.
     * @see #registerBean(Class, String, Class...)
     */
    public void setEnvironment(Environment environment) {
        this.conditionEvaluator = new ConditionEvaluator(this.registry, environment, null);
    }



    /**
     * Set the {@code ScopeMetadataResolver} to use for registered component classes.
     * <p>The default is an {@link AnnotationScopeMetadataResolver}.
     */
    public void setScopeMetadataResolver(@Nullable ScopeMetadataResolver scopeMetadataResolver) {
        this.scopeMetadataResolver =
                (scopeMetadataResolver != null ? scopeMetadataResolver : new AnnotationScopeMetadataResolver());
    }


    /**
     * Register one or more component classes to be processed.
     * <p>Calls to {@code register} are idempotent; adding the same
     * component class more than once has no additional effect.
     * @param componentClasses one or more component classes,
     * e.g. {@link Configuration @Configuration} classes
     */
    public void register(Class<?>... componentClasses) {
        for (Class<?> componentClass : componentClasses) {
            registerBean(componentClass);
        }
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations.
     * @param beanClass the class of the bean
     */
    public void registerBean(Class<?> beanClass) {
        doRegisterBean(beanClass, null, null, null, null);
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations.
     * @param beanClass the class of the bean
     * @param name an explicit name for the bean
     * (or {@code null} for generating a default bean name)
     * @since 5.2
     */
    public void registerBean(Class<?> beanClass, @Nullable String name) {
        doRegisterBean(beanClass, name, null, null, null);
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations.
     * @param beanClass the class of the bean
     * @param qualifiers specific qualifier annotations to consider,
     * in addition to qualifiers at the bean class level
     */
    @SuppressWarnings("unchecked")
    public void registerBean(Class<?> beanClass, Class<? extends Annotation>... qualifiers) {
        doRegisterBean(beanClass, null, qualifiers, null, null);
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations.
     * @param beanClass the class of the bean
     * @param name an explicit name for the bean
     * (or {@code null} for generating a default bean name)
     * @param qualifiers specific qualifier annotations to consider,
     * in addition to qualifiers at the bean class level
     */
    @SuppressWarnings("unchecked")
    public void registerBean(Class<?> beanClass, @Nullable String name,
                             Class<? extends Annotation>... qualifiers) {

        doRegisterBean(beanClass, name, qualifiers, null, null);
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations, using the given supplier for obtaining a new
     * instance (possibly declared as a lambda expression or method reference).
     * @param beanClass the class of the bean
     * @param supplier a callback for creating an instance of the bean
     * (may be {@code null})
     * @since 5.0
     */
    public <T> void registerBean(Class<T> beanClass, @Nullable Supplier<T> supplier) {
        doRegisterBean(beanClass, null, null, supplier, null);
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations, using the given supplier for obtaining a new
     * instance (possibly declared as a lambda expression or method reference).
     * @param beanClass the class of the bean
     * @param name an explicit name for the bean
     * (or {@code null} for generating a default bean name)
     * @param supplier a callback for creating an instance of the bean
     * (may be {@code null})
     * @since 5.0
     */
    public <T> void registerBean(Class<T> beanClass, @Nullable String name, @Nullable Supplier<T> supplier) {
        doRegisterBean(beanClass, name, null, supplier, null);
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations.
     * @param beanClass the class of the bean
     * @param name an explicit name for the bean
     * (or {@code null} for generating a default bean name)
     * @param supplier a callback for creating an instance of the bean
     * (may be {@code null})
     * @param customizers one or more callbacks for customizing the factory's
     * {@link org.springframework.beans.factory.config.BeanDefinition}, e.g. setting a lazy-init or primary flag
     * @since 5.2
     */
    public <T> void registerBean(Class<T> beanClass, @Nullable String name, @Nullable Supplier<T> supplier,
                                 BeanDefinitionCustomizer... customizers) {

        doRegisterBean(beanClass, name, null, supplier, customizers);
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations.
     * @param beanClass the class of the bean
     * @param name an explicit name for the bean
     * @param qualifiers specific qualifier annotations to consider, if any,
     * in addition to qualifiers at the bean class level
     * @param supplier a callback for creating an instance of the bean
     * (may be {@code null})
     * @param customizers one or more callbacks for customizing the factory's
     * {@link BeanDefinition}, e.g. setting a lazy-init or primary flag
     * @since 5.0
     */
    private <T> void doRegisterBean(Class<T> beanClass, @Nullable String name,
                                    @Nullable Class<? extends Annotation>[] qualifiers, @Nullable Supplier<T> supplier,
                                    @Nullable BeanDefinitionCustomizer[] customizers) {

        AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(beanClass);

        abd.setInstanceSupplier(supplier);
        ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
        abd.setScope(scopeMetadata.getScopeName());
        String beanName = name;

        /*AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);
        if (qualifiers != null) {
            for (Class<? extends Annotation> qualifier : qualifiers) {
                if (Primary.class == qualifier) {
                    abd.setPrimary(true);
                }
                else if (Lazy.class == qualifier) {
                    abd.setLazyInit(true);
                }
                else {
                    abd.addQualifier(new AutowireCandidateQualifier(qualifier));
                }
            }
        }
        if (customizers != null) {
            for (BeanDefinitionCustomizer customizer : customizers) {
                customizer.customize(abd);
            }
        }

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
        definitionHolder = AnnotationConfigUtils.applyScopedProxyMode(scopeMetadata, definitionHolder, this.registry);
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, this.registry);*/
    }



}
