import 'dart:math';

import 'package:flutter/material.dart';

class RadialMenuPainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    // TODO: implement paint
    var centerX = size.width / 2;
    var centerY = size.height / 2;

    var centre = Offset(size.width / 2, size.height / 2);
    var radius = min(centerX, centerY);

    var fillBrush = Paint()
      ..color = Color(0xFF444974)
      ..style = PaintingStyle.fill;

    var holeBrush = Paint()..color = Colors.grey.shade300;

    // Draw canvas with a circle shaped hole in radial menu
    final Path path = Path();
    path.fillType = PathFillType.evenOdd;
    path.addOval(Rect.fromCircle(center: centre, radius: 150));
    path.addOval(Rect.fromCircle(center: centre, radius: 35));
    canvas.drawPath(path, holeBrush);
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    // TODO: implement shouldRepaint
    return true;
  }
}
