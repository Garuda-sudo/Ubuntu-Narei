import 'dart:math';

import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:vector_math/vector_math_64.dart' show radians;

class RadialMenuAnimation extends StatelessWidget {
  RadialMenuAnimation({Key? key, required this.controller})
      : scale = Tween<double>(begin: 1.0, end: 0.0).animate(
            CurvedAnimation(parent: controller, curve: Curves.fastOutSlowIn)),
        translation = Tween(begin: 0.0, end: 150.0).animate(
            CurvedAnimation(parent: controller, curve: Curves.elasticInOut)),
        opacity = Tween(begin: 0.0, end: 100.0).animate(CurvedAnimation(
            parent: controller, curve: const Interval(0.4, 1.0))),
        super(key: key);

  final AnimationController controller;
  final Animation<double> scale;
  final Animation<double> translation;
  final Animation<double> opacity;

  @override
  Widget build(BuildContext context) {
    return AnimatedBuilder(
        animation: controller,
        builder: (context, builder) {
          return Stack(
            alignment: Alignment.center,
            children: [
              _buildButton(-90, Colors.amber, Icon(Icons.monetization_on)),
              _buildButton(-45, Colors.amber, Icon(Icons.monetization_on)),
              _buildButton(-135, Colors.amber, Icon(Icons.monetization_on)),
              Transform.scale(
                scale: scale.value - 1,
                child: FloatingActionButton(
                  onPressed: _close,
                  backgroundColor: Colors.amber,
                  child: const Icon(Icons.close),
                ),
              ),
              Transform.scale(
                scale: scale.value,
                child: FloatingActionButton(
                  backgroundColor: Colors.purple[50],
                  onPressed: _open,
                  child: const Icon(Icons.add),
                ),
              ),
            ],
          );
        });
  }

  _buildButton(double angle, Color color, Icon icon) {
    final double radian = radians(angle);
    return Transform(
      transform: Matrix4.identity()
        ..translate((translation.value * cos(radian)),
            (translation.value * sin(radian))),
      child: FadeTransition(
        opacity: opacity,
        child: Container(
          height: 65,
          width: 90,
          decoration: BoxDecoration(
              color: color,
              borderRadius: BorderRadius.circular(8.0),
              // image: const DecorationImage(
              //     opacity: 0.9,
              //     fit: BoxFit.cover,
              //     image: AssetImage("/images/background_image_1.jpg")),
              boxShadow: [
                BoxShadow(
                    blurRadius: 8,
                    color: Colors.black.withOpacity(0.5),
                    offset: const Offset(0, 7)),
              ]),
          child: Stack(
            children: [Text("Recurring")],
          ),
        ),
      ),
    );
  }

  _open() {
    controller.forward();
  }

  _close() {
    controller.reverse();
  }
}
