import 'package:flutter/material.dart';

class ParallaxPosition extends StatelessWidget {
  const ParallaxPosition(
      {super.key,
      required this.asset,
      required this.top,
      this.right,
      this.left});

  final String asset;
  final double? top;
  final double? right;
  final double? left;

  @override
  Widget build(BuildContext context) {
    return Positioned(
      top: top,
      left: left,
      right: right,
      child: SizedBox(
        height: 150,
        child: Image(
          image: AssetImage(asset),
          fit: BoxFit.cover,
        ),
      ),
    );
  }
}
