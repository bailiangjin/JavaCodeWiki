# 注解实现枚举示例

```
public interface GenderType {

    /**
     * 未知
     */
    int UN_KNOWN = 0;

    /**
     * 男性
     */
    int MALE = 1;
    /**
     * 女性
     */
    int FEMALE = 2;


    // 自定义一个注解 Type
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            UN_KNOWN,
            MALE,
            FEMALE
    })
    @interface Type {
    }

}
```



''' 

```

public class User {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 性别
     */
    @GenderType.Type
    private int gender;
    /**
     * 年龄
     */
    private int age;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String phoneNumber;

    public User() {
    }
}
```

```

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;
/**
 * Denotes that the annotated element of integer type, represents
 * a logical type and that its value should be one of the explicitly
 * named constants. If the IntDef#flag() attribute is set to true,
 * multiple constants can be combined.
 * <p>
 * Example:
 * <pre><code>
 *  &#64;Retention(SOURCE)
 *  &#64;IntDef({NAVIGATION_MODE_STANDARD, NAVIGATION_MODE_LIST, NAVIGATION_MODE_TABS})
 *  public @interface NavigationMode {}
 *  public static final int NAVIGATION_MODE_STANDARD = 0;
 *  public static final int NAVIGATION_MODE_LIST = 1;
 *  public static final int NAVIGATION_MODE_TABS = 2;
 *  ...
 *  public abstract void setNavigationMode(@NavigationMode int mode);
 *  &#64;NavigationMode
 *  public abstract int getNavigationMode();
 * </code></pre>
 * For a flag, set the flag attribute:
 * <pre><code>
 *  &#64;IntDef(
 *      flag = true,
 *      value = {NAVIGATION_MODE_STANDARD, NAVIGATION_MODE_LIST, NAVIGATION_MODE_TABS})
 * </code></pre>
 */
@Retention(SOURCE)
@Target({ANNOTATION_TYPE})
public @interface IntDef {
    /** Defines the allowed constants for this element */
    long[] value() default {};

    /** Defines whether the constants can be used as a flag, or just as an enum (the default) */
    boolean flag() default false;
}

```