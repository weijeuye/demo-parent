package ${controllerUrl};

import ${abstractControllerUrl}.BaseController;
import ${entityUrl}.${entityName};
import ${serviceUrl}.I${entityName}Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**   
 *
 * <p>说明： ${entityComment}API接口层</P>
 * @version: ${version}
 * @author: ${author}
 *
 */
@Api(description = "${entityComment}",value="${entityComment}" )
@RestController
@RequestMapping("/${objectName}")
public class ${entityName}Controller extends BaseController<I${entityName}Service,${entityName}>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}