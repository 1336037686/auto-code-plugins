package ${packagePosition};

/**
 *
 * @author
 * @date ${nowDateTime}
 */
public class ${className} {
    private String name;
    private Integer age;

    public ${className}() {

    }

    public ${className}(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "${className}{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}