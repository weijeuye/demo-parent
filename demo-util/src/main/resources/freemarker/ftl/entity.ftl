package ${entityUrl};

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * <p>说明： ${entityComment}实体类</P>
 * @version: ${version}
 * @author: ${author}
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("${table}")
public class ${entityName} extends Model<${entityName}> {

	private static final long serialVersionUID = ${agile}L;

<#list cis as ci>
 <#if ci.comment !="">
    /**
     * ${ci.comment}
     */
 </#if>
 <#if ci.javaType=="Date">
  <#if ci.jdbcType=="date">
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  <#elseif ci.jdbcType=="time">
    @DateTimeFormat(pattern = "HH:mm:ss")
	@JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
  <#else>
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  </#if>
 </#if>
 <#if ci.property=="id">
	@TableId(value = "id", type = IdType.AUTO)
 </#if>
    private ${ci.javaType} ${ci.property};
</#list>
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
	