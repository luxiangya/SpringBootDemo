//package com.jn.promotion.interceptor;
//
//
//import com.jn.promotion.common.result.ResultResponseEnum;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.reflection.DefaultReflectorFactory;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.SystemMetaObject;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.Connection;
//import java.util.Properties;
//
//@Slf4j
//@Component
//@Intercepts(value = {
//        @Signature(type = StatementHandler.class,
//                method = "prepare",
//                args = {Connection.class, Integer.class})})
//public class MySqlInterceptor implements Interceptor {
//    // 修改sql，添加前后缀
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
//
//        MetaObject metaStatementHandler =
//                MetaObject.forObject(
//                        statementHandler,
//                        SystemMetaObject.DEFAULT_OBJECT_FACTORY,
//                        SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
//                        new DefaultReflectorFactory()
//                );
//
//        addSchema(metaStatementHandler);
//
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        if (target instanceof StatementHandler) {
//            return Plugin.wrap(target, this);
//        } else {
//            return target;
//        }
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//
//    private void addSchema(MetaObject metaStatementHandler) throws Throwable {
//        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
//
//        if (log.isInfoEnabled()) {
//            log.info("add schema before, the sql is [{}]", originalSql);
//        }
//
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//
//        assert servletRequestAttributes != null;
//
//        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
//
//        final String schema = httpServletRequest.getHeader("Schema");
//
//        if (log.isInfoEnabled()) {
//            log.info("current schema is [{}]", schema);
//        }
//
//        if (!StringUtils.isEmpty(originalSql) && !StringUtils.isEmpty(schema)) {
//            String addSchemaSql = String.format("/*!mycat:schema = %s*/ %s", schema, originalSql);
//
//            metaStatementHandler.setValue("delegate.boundSql.sql", addSchemaSql);
//        } else {
//            throw new Throwable(ResultResponseEnum.MYCAT_ERROR.getDesc());
//        }
//
//        if (log.isInfoEnabled()) {
//            originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
//
//            log.info("after schema before, the sql is [{}]", originalSql);
//        }
//    }
//}
