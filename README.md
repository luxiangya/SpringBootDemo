# SpringBootDemo 记得加星呦
spiingBoo框架脚手架
# 适应用快速搭建开发需求
# 实现了统一返回体
## com.jn.promotion.exception.ResponseResultHandlerAdvice 
   通过继承ResponseBodyAdvice 实现返回体的统一处理(优化了返回体是String的特殊处理,禁止controller返回Object)
# 异常的统一捕捉
## com.jn.promotion.exception.ResponseResultHandlerAdvice 
   通过对异常类的捕捉，区分具体异常信息,返回不同的异常错误码
# 自定义异常
## com.jn.promotion.exception.BusinessException
   在项目业务中，一些出现错误的地方，可以用自定义异常返回(可以返回异常码和异常描述)
# knife4j 文档api
## swageer的加强版文件api工具，对SwaggerUI界面就行了优化
# 实体转换 do dto 之间转换的工具类
## 在业务之间进行转换的工具

