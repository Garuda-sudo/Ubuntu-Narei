import 'package:flutter/material.dart';

class LandingPageGraphComponent extends StatefulWidget {
  const LandingPageGraphComponent({super.key});

  @override
  State<LandingPageGraphComponent> createState() =>
      _LandingPageGraphComponentState();
}

class _LandingPageGraphComponentState extends State<LandingPageGraphComponent> {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 150,
      width: 70,
      color: Colors.amber,
    );
  }
}
