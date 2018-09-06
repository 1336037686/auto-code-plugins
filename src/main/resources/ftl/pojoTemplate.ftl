package ${packagePosition};


<#list importPackages as package>
import java.util.${package};
</#list>

/**
 *
 * @author
 * @date ${nowDateTime?date}
 */
public class ${className} {
    <#list attributes as attr>
    private ${attr.attrType} ${attr.attrName};
    </#list>

    public ${className}() {

    }

    <#if (attributes?size>0)>
    public ${className}(<#list attributes as attr>${attr.attrType} ${attr.attrName}<#if (attr_has_next?c) != 'false' >, </#if></#list>) {
    <#list attributes as attr>
        this.${attr.attrName} = ${attr.attrName};
    </#list>
    }
    </#if>


    <#list attributes as attr>
    <#if attr.getterKey == 1>
    public ${attr.attrType} get<@UpperInitials value=attr.attrName />() {
        return ${attr.attrName};
    }
    </#if>

    <#if attr.setterKey == 1>
    public void set<@UpperInitials value=attr.attrName />(${attr.attrType} ${attr.attrName}) {
        this.${attr.attrName} = ${attr.attrName};
    }
    </#if>
    </#list>


    <#if mainKey == 1>
    public static void main(String[] args) {

    }
    </#if>
}