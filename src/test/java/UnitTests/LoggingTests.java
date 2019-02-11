package UnitTests;

import Logging.IFLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoggingTests {

    private IFLogger _log = new IFLogger("LoggingTests");

    @Test
    public void LogDebugTest(){
        _log.debug("Test Debug");
        Assert.assertTrue(true);
    }

    @Test
    public void LogInfoTest(){
        _log.info("Test Info");
        Assert.assertTrue(true);
    }

    @Test
    public void LogFatalTest(){
        _log.fatal("Test Fatal");
        Assert.assertTrue(true);
    }

    @Test
    public void LogErrorTest(){
        _log.error("Test Error");
        Assert.assertTrue(true);
    }

    @Test
    public void LogTraceTest(){
        _log.trace("Test Trace");
        Assert.assertTrue(true);
    }

    @Test
    public void LogWarnTest(){
        _log.warn("Test Warn");
        Assert.assertTrue(true);
    }
}
