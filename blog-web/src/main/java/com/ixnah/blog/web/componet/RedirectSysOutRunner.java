package com.ixnah.blog.web.componet;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RedirectSysOutRunner implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) {
    SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
  }
}
