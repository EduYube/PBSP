package com.eyubero.pbsp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eyubero.pbsp.R

import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

import java.util.Arrays
import java.util.Collections

class GraphicFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_graphic, container, false)
        mScatterPlot = rootView.findViewById(R.id.scatterPlot) as GraphView
        activity!!.title = this.javaClass.simpleName.substringBefore("Fragment")
        activity!!.window.navigationBarColor = resources.getColor(R.color.blue_pbsp)
        activity!!.window.statusBarColor = resources.getColor(R.color.blue_pbsp)

        mScatterPlot.viewport.isScalable = false
        mScatterPlot.viewport.setScalableY(false)
        mScatterPlot.viewport.isScrollable = false
        mScatterPlot.viewport.setScrollableY(false)

        mScatterPlot.viewport.isYAxisBoundsManual = true
        mScatterPlot.viewport.setMaxY(20.0)
        mScatterPlot.viewport.setMinY(-20.0)

        mScatterPlot.viewport.isXAxisBoundsManual = true
        mScatterPlot.viewport.setMaxX(20.0)
        mScatterPlot.viewport.setMinX(-20.0)

        mScatterPlot.gridLabelRenderer.numHorizontalLabels = 9
        mScatterPlot.gridLabelRenderer.numVerticalLabels = 9

        return rootView
    }

    companion object {

        fun newInstance() = GraphicFragment()

        lateinit var mScatterPlot: GraphView

        fun createScatterPlot(a: Int, b: Int, c: Int, d: Int) {
            try {
                mScatterPlot.removeAllSeries()
                val series1: LineGraphSeries<DataPoint>
                val series2: LineGraphSeries<DataPoint>
                val series3: LineGraphSeries<DataPoint>
                val series4: LineGraphSeries<DataPoint>
                val aNeg = a * -1
                val dNeg = d * -1

                val x = Arrays.asList(aNeg, b, c, dNeg)
                val y = Arrays.asList(a, b, c, d)

                val xMax = Collections.max(x)
                val xMin = Collections.min(x)
                val yMax = Collections.max(y)
                val yMin = Collections.min(y)


                val totals = Arrays.asList(xMax, xMin, yMax, yMin)

                var totalMax = Collections.max(totals)
                var totalMin = Collections.min(totals)

                if (totalMax < 0)
                    totalMax *= -1
                if (totalMin < 0)
                    totalMin *= -1

                var best = 0

                if (totalMax >= totalMin)
                    best = totalMax
                else
                    best = totalMin

                if (best % 2 != 0)
                    best++


                series1 = if (aNeg <= c) {
                    LineGraphSeries(arrayOf(DataPoint(aNeg.toDouble(), a.toDouble()), DataPoint(c.toDouble(), c.toDouble())))
                } else {
                    LineGraphSeries(arrayOf(DataPoint(c.toDouble(), c.toDouble()), DataPoint(aNeg.toDouble(), a.toDouble())))
                }

                series2 = if (dNeg <= c) {
                    LineGraphSeries(arrayOf(DataPoint(dNeg.toDouble(), d.toDouble()), DataPoint(c.toDouble(), c.toDouble())))
                } else {
                    LineGraphSeries(arrayOf(DataPoint(c.toDouble(), c.toDouble()), DataPoint(dNeg.toDouble(), d.toDouble())))
                }

                series3 = if (b <= dNeg) {
                    LineGraphSeries(arrayOf(DataPoint(b.toDouble(), b.toDouble()), DataPoint(dNeg.toDouble(), d.toDouble())))
                } else {
                    LineGraphSeries(arrayOf(DataPoint(dNeg.toDouble(), d.toDouble()), DataPoint(b.toDouble(), b.toDouble())))
                }

                series4 = if (aNeg <= b) {
                    LineGraphSeries(arrayOf(DataPoint(aNeg.toDouble(), a.toDouble()), DataPoint(b.toDouble(), b.toDouble())))
                } else {
                    LineGraphSeries(arrayOf(DataPoint(b.toDouble(), b.toDouble()), DataPoint(aNeg.toDouble(), a.toDouble())))
                }

                mScatterPlot.addSeries(series1)
                mScatterPlot.addSeries(series2)
                mScatterPlot.addSeries(series3)
                mScatterPlot.addSeries(series4)

                mScatterPlot.viewport.isScalable = true
                mScatterPlot.viewport.setScalableY(true)
                mScatterPlot.viewport.isScrollable = false
                mScatterPlot.viewport.setScrollableY(false)

            } catch (e: NullPointerException) {
            }

        }
    }
}

