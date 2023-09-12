import styles from "./customButton.module.css";

export default function CustomButton(props) {
  const { as, className, children, ...otherProps } = props;

  let combinedClassName = styles["button-24"];
  if (className) {
    combinedClassName += " " + className;
  }

  const Element = as || "button";

  return (
    <Element className={combinedClassName} {...otherProps}>
      {children}
    </Element>
  );
}
