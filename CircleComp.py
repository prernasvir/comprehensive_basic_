import math

class CircleComp:
    def __init__(self):
        self.radius = 0.0
        self.diameter = 0.0
        self.circumference = 0.0
        self.area = 0.0

    def calculate(self):
        # Read the radius from the user
        self.radius = float(input("Enter the radius of the circle: "))

        # Calculate the diameter
        self.diameter = self.radius * 2.0

        # Calculate the circumference
        self.circumference = 2 * math.pi * self.radius

        # Calculate the area
        self.area = math.pi * self.radius * self.diameter

    def display(self):
        # Display the calculated values
        print(f"Diameter: {self.diameter}")
        print(f"Area: {self.area}")


# Create an instance of the CircleComp class
circle = CircleComp()

# Calculate and display the values
circle.calculate()
circle.display()
