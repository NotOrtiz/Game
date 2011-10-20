package util;

public class Clock
{
    private long _lastUpdate = System.nanoTime();
    private double _frameTime = 0.0;
    private double _elapsedTime = 0.0;

    public Clock()
    {
    }

    public void reset()
    {
        _lastUpdate = System.nanoTime();
        _frameTime = _elapsedTime = 0.0;
    }
    public void update()
    {
        final long curTime = System.nanoTime();
        _frameTime = ( ( double )( curTime - _lastUpdate ) ) / 1000000000;
        _elapsedTime += _frameTime;
        _lastUpdate = curTime;
    }
    public double getFrameTime()
    {
        return _frameTime;
    }
    public double getElapsedTime()
    {
        return _elapsedTime;
    }
}