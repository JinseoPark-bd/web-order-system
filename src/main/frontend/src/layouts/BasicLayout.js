import BasicMenu from "../components/menus/BasicMenu";

const BasicLayout = ({children}) => {
  return (
    <>
        <BasicMenu/>
        <div className="bg-white">
            <main>
                {children}
            </main>
        </div>
    </>
  );
}

export default BasicLayout;
