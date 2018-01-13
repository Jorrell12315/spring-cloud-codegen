package cn.springcloud.codegen.component.generator.zuul;

import cn.springcloud.codegen.engine.context.SkeletonContext;
import cn.springcloud.codegen.engine.generator.SkeletonFileGenerator;
import cn.springcloud.codegen.engine.property.SkeletonProperties;
import cn.springcloud.codegen.engine.util.SkeletonUtil;
import cn.springcloud.codegen.engine.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent.
 * @createdOn 2018/01/08 22:41
 */
public class ZuulPomXmlGenerator extends SkeletonFileGenerator {

    public ZuulPomXmlGenerator(SkeletonContext skeletonContext, SkeletonProperties skeletonProperties) {
        super(skeletonContext.clone("zuul", ZuulPomXmlGenerator.class), skeletonProperties);
    }

    @Override
    protected String getFileName() {
        return "pom.xml";
    }

    @Override
    protected String getTemplateName() {
        return "pom.xml.template";
    }

    @Override
    protected Object getDataModel() {
        Map<String, Object> dataModel = new HashMap<String, Object>();

        dataModel.put("springBootVersion", skeletonProperties.getString("springBootVersion"));
//        dataModel.put("springCloudVersion", skeletonProperties.getString("springCloudVersion"));
        dataModel.put("javaVersion", skeletonProperties.getString("javaVersion"));

        dataModel.put("pomGroupId", skeletonProperties.getString("pomGroupId"));
        dataModel.put("pomArtifactId", skeletonProperties.getString("pomArtifactId") + "-" + getSkeletonContext().getProjectType());
        dataModel.put("pomName", skeletonProperties.getString("pomArtifactId") + " " + StringUtil.firstLetterToUpper(getSkeletonContext().getProjectType()));

        dataModel.put("mainClass", SkeletonUtil.getBasePackagePath(getSkeletonContext().getProjectType(), skeletonProperties) + "." + StringUtil.firstLetterToUpper(getSkeletonContext().getProjectType()) + "Application");
        return dataModel;
    }
}